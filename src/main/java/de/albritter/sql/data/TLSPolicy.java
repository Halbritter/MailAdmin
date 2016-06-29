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

package de.albritter.sql.data;

import lombok.Setter;

/**
 * Created by albritter on 04.06.16.
 */
public class TLSPolicy extends ADataObject {

    public static String[] polices = new String[]{"NONE", "MAY", "ENCRYPT", "DANE", "DANE_ONLY", "VERYFY", "SECURE"};
    @Setter
    protected int active;
    @Setter
    private String domain;
    @Setter
    private String policy;
    @Setter
    private String parms;

    public String[] getDataAsArray() {
        return new String[]{domain, policy.toLowerCase(), parms, String.valueOf(active)};
    }


}
