package cn.wxxlamp.spider.util;

import cn.wxxlamp.spider.model.AppDesc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wxxlamp
 * @date 2021/04/12~13:20
 */
public class IoUtils {

    private static final Map<String, File> FILE_MAP = new HashMap<>(4);

    private static File checkFile(String fileName) {
        File file = FILE_MAP.get(fileName);
        if (file == null) {
            file = new File("\\wxx\\" + fileName);
            FILE_MAP.put(fileName, file);
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    public static void writeFile(String key, AppDesc appDesc, boolean append) {
        File file = checkFile(key);
        try (FileWriter writer = new FileWriter(file,append);
             BufferedWriter out = new BufferedWriter(writer)
        ) {
                out.write(appDesc + "\r\n");
                out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
