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

package de.albritter.gui.tables;

import java.util.EventListener;

/**
 * Created by hhalbritter on 13.06.2016.
 */
public interface UpdateTabel extends EventListener {
    void updateDomainTable(Object[][] data);

    void updateMailboxTable(Object[][] data);

    void updateAliasTable(Object[][] data);

    void updateTLSTable(Object[][] data);
}
