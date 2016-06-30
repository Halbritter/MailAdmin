
/*
 * This file is part of MailAdmin.
 *
 *     MailAdmin is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 2 of the License, or
 *     (at your option) any later version.
 *
 *     MailAdmin is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with MailAdmin.  If not, see <http://www.gnu.org/licenses/>.
 */

package de.albritter.sql.data;

import lombok.Setter;

/**
 * Created by albritter on 04.06.16.
 */
public class Aliases extends ADataObject {
    @Setter
    protected int active;
    @Setter
    private String sourceUsername;
    @Setter
    private String sourceDomain;
    @Setter
    private String destinationUsername;
    @Setter
    private String destinationDomain;

    public String[] getDataAsArray() {
        return new String[]{sourceUsername, sourceDomain, destinationUsername, destinationDomain, String.valueOf(active)};
    }
}
