package com.haulmont.thesis.composite.tests.ui.pages.utils;

import com.haulmont.masquerade.Selectors;
import com.haulmont.thesis.composite.tests.ui.consts.Constant;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class PageManager {
    private static Map<String, ?> pages;

    static {
        initPageManager();
    }

    public static <L> void run(L link) {
        bindPageLinks(link);
    }

    public static <P> P getPage(Class pageClass) {
        return (P) pages.get(pageClass.getName());
    }

    private static String mapKey(Class pageClass) {
        return pageClass.getName();
    }

    private static Map<String, ?> createPages() {
        Reflections classReflection = new Reflections(Constant.PACKAGE_PATH.getValue());
        return Stream.of(
                classReflection.getTypesAnnotatedWith(Page.class),
                classReflection.getTypesAnnotatedWith(PageElement.class)
        )
                .flatMap(Collection::stream)
                .collect(toMap(PageManager::mapKey, Selectors::$c));
    }

    private static void initPageManager() {
        pages = createPages();
        pages
                .values()
                .forEach(page -> Arrays
                        .stream(page
                                .getClass()
                                .getDeclaredFields())
                        .filter(field ->
                                field.getAnnotation(PageBinding.class) != null
                        ).forEach(field -> {
                            try {
                                field.setAccessible(true);
                                field.set(page, pages.get(field.getType().getName()));
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        }));
    }

    private static <L> void bindPageLinks(L link) {
        Reflections filedReflection = new Reflections(Constant.PACKAGE_PATH.getValue(), new FieldAnnotationsScanner());
        Set<Field> annotatedPageLinks = filedReflection.getFieldsAnnotatedWith(PageBinding.class);
        annotatedPageLinks
                .stream()
                .filter(field -> field.getDeclaringClass().equals(link.getClass()))
                .forEach(fieldLink -> {
                    try {
                        fieldLink.setAccessible(true);
                        fieldLink.set(link, pages.get(fieldLink.getType().getName()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
    }
}
