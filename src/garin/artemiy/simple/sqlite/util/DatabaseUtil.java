package garin.artemiy.simple.sqlite.util;

import garin.artemiy.simple.sqlite.annotations.Column;
import garin.artemiy.simple.sqlite.annotations.Table;

import java.lang.reflect.Field;

/**
 * author: Artemiy Garin
 * Copyright (C) 2013 SQLite Simple Project
 * *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * *
 * http://www.apache.org/licenses/LICENSE-2.0
 * *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class DatabaseUtil {

    public static String getColumnName(Field field) {
        Column annotationColumn = field.getAnnotation(Column.class);
        String column = null;
        if (annotationColumn != null) {
            if (annotationColumn.name().equals(Constants.EMPTY)) {
                column = field.getName();
            } else {
                column = annotationColumn.name();
            }
        }
        return column;
    }

    public static String getTableName(Class<?> tClass) {
        Table annotationTable = tClass.getAnnotation(Table.class);
        String table = tClass.getSimpleName();
        if (annotationTable != null) {
            if (!annotationTable.name().equals(Constants.EMPTY)) {
                table = annotationTable.name();
            }
        }
        return table;
    }

}
