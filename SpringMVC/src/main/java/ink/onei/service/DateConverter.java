package ink.onei.service;

import org.springframework.core.convert.converter.Converter;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @Author: nekotako
 * @Description: 字符串转换器
 * @Date: 20/12/2023 09:46 Wednesday
 */

public class DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        // 判断
        if (source == null) {
            throw new RuntimeException("参数不能为空");
        }
        Date date = null;
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            // 解析字符串
            date = (java.sql.Date) df.parse(source);
        } catch (Exception e) {
            e.getMessage();
        }
        return date;
    }
}
