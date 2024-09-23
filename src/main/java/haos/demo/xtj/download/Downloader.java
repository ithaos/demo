package haos.demo.xtj.download;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Downloader {

    static final String baseDir = "/Users/haos/Desktop/xtj/";

    static final String chapterUrl = "https://apj-course.xtjzx.cn/course/%s/chapter.json?t=%s";
    static final String lessonUrl = "https://apj-course.xtjzx.cn/course/%s/videoDownload.json?t=%s";
    static final String attachUrl = "https://apj-course.xtjzx.cn/course/%s/handout.json?t=%s";

    //3279 言语
    //3277 判断
    public static void main(String[] args) {
        // 获得课程ID
        String courseId = scanner("请输入课程ID");
        String chapterRes = HttpUtil.get(String.format(chapterUrl, courseId, System.currentTimeMillis()));
        // 获得章节
        List<JSONObject> chapters = JSONPath.read(chapterRes, "$.data.data.chapterListCached.chapter", JSONArray.class);
        Map<String, JSONObject> chapterMap = chapters.stream()
                .collect(Collectors.toMap(obj -> obj.getString("id"), Function.identity()));
        chapterMap.forEach((chapterId, chapter) -> System.out.println(">" + chapterId + "-" + chapter.get("chapterName") + "\n"));
        // 选择章节
        String selectCourseId = scanner("请输入章节ID");
        JSONObject courseObj = chapterMap.get(selectCourseId);
        while (Objects.isNull(courseObj)) {
            selectCourseId = scanner("输入有误,请重新输入章节ID");
            courseObj = chapterMap.get(selectCourseId);
        }
        // 创建文件夹
        String dirName = baseDir + courseObj.getString("chapterName");
        FileUtil.mkdir(dirName);
        // 视频列表
        Map<String, JSONObject> lessonMap = courseObj.getJSONArray("chapterLesson")
                .stream().collect(Collectors.toMap(obj -> JSONObject.parseObject(String.valueOf(obj)).getString("id"), obj -> JSONObject.parseObject(String.valueOf(obj))));
        lessonMap.forEach((lessonId, lesson) -> System.out.println(">" + lessonId + "-" + lesson.get("name")));
        // 是否全部下载
        List<JSONObject> lessons = new ArrayList<>();
        String allDown = scanner("是否全部下载? y or n");
        if (Objects.equals(allDown, "y")) {
            lessons.addAll(lessonMap.values());
        } else {
            String[] selectLessonIds = scanner("请输入章节ID,以逗号分割").split(",");
            for (String selectLessonId : selectLessonIds) {
                lessons.add(lessonMap.get(selectLessonId));
            }
        }
        // 待下载列表
        List<JSONObject> download = new ArrayList<>();
        // 获得下载链接
        String lessonRes = HttpUtil.get(String.format(lessonUrl, courseId, System.currentTimeMillis()));
        JSONObject lessonResMap = JSONPath.read(lessonRes, "$.data.data", JSONObject.class);
        lessons.forEach(lesson -> {
            String lessonId = lesson.getString("id");
            JSONObject obj = lessonResMap.getObject(lessonId, JSONObject.class).getJSONObject("courseVideo");
            obj.put("lessonId", lessonId);
            obj.put("name", lesson.getString("name"));
            download.add(obj);
        });
        // 开始下载
        download.forEach(obj -> {
            try {
                System.out.println("开始下载:" + obj);
                FileOutputStream fos = new FileOutputStream(FileUtil.newFile(dirName + "/" + obj.getString("name") + ".mp4"));
                fos.write(HttpUtil.downloadBytes(obj.getString("highQualityUrl")));
                fos.close();
                System.out.println("下载完成:" + obj);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        System.out.println(tip);
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new RuntimeException("请输入正确的" + tip + "！");
    }
}
