/*
 * This file is part of VMail.
 *
 *     VMail is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 2 of the License, or
 *     (at your option) any later version.
 *
 *     VMail is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 */

package de.albritter.utils;

/**
 * Created by albritter on 23.07.16.
 */
public class StringUtils {

    public static boolean verifyEmailAddressFormat(String str) {
        if (numberOfOccurrences(str, "@") != 1 || !str.contains("."))
            return false;
        return !(str.charAt(0) == '.' || str.charAt(str.indexOf("@") - 1) == '.');
    }

    public static int numberOfOccurrences(String str, String c) {
        return str.length() - str.replace("@", "").length();
    }
}
