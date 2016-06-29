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

import java.util.Random;

/**
 * Created by albritter on 05.06.16.
 */
public class CryptoUtils {
    public static String getNewSalt() {
        char[] validChars = "abcdefghijklmnoqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVXYZ0123456789".toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            stringBuilder.append(validChars[(new Random()).nextInt(validChars.length - 1)]);
        }

        //   return stringBuilder.toString();
        return stringBuilder.toString();
    }
}
