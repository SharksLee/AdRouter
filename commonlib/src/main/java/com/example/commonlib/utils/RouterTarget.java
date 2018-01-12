package com.example.commonlib.utils;

/**
 * 描述：保存Activity成员状态，
 * 功能：在onSaveInstanceState时会保存有此注解的成员变量，变量需实现{@link java.io.Serializable}或{@link android.os.Parcelable}接口
 * 支持LinkedHashMap
 * Created by KasoGG on 2017/11/17.
 */

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface RouterTarget {
    String value();
}