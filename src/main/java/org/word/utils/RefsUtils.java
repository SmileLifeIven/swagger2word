package org.word.utils;

import org.word.model.ModelAttr;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author ivenhan
 * @Date: 2020/10/15
 */

public class RefsUtils {

    public static ModelAttr parsePaths(String ref, Map<String, Map<String, Object>> paths) {
    	//其他类型
        ModelAttr modelAttr = new ModelAttr();

        // 去除 #/paths/
        ref = ref.substring(8);

        String[] refPaths = ref.split("/");

         for(int i = 0; i < refPaths.length; i++){

         }


        return modelAttr;
    }
}