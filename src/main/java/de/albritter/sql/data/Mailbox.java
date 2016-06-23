/*
 * Copyright (C) 2016 albritter
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package de.albritter.sql.data;

import lombok.Setter;

/**
 * Created by albritter on 04.06.16.
 */
public class Mailbox extends ADataObject {
    @Setter
    protected int active;
    @Setter
    private String username;
    @Setter
    private String domain;
    @Setter
    private String password;
    @Setter
    private int quota;
    @Setter
    private int sendonly;

    public String[] getDataAsArray() {
        System.out.println("{SHA512-CRYPT}" + password);
        //return new String[]{username, domain, "{SHA512-CRYPT}" + Sha512Crypt.Sha512_crypt(password, "$6$"+CryptoUtils.getNewSalt()+"$", 5000), String.valueOf(quota), String.valueOf(enabled), String.valueOf(sendonly)};
        return new String[]{username, domain, "{SHA512-CRYPT}" + password, String.valueOf(quota), String.valueOf(active), String.valueOf(sendonly)};
    }
}
