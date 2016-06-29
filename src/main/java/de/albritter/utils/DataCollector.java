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

import de.albritter.sql.MySQLHandler;
import de.albritter.sql.data.ADataObject;
import de.albritter.sql.data.Aliases;
import de.albritter.sql.data.Domain;
import de.albritter.sql.data.Mailbox;
import de.albritter.sql.data.TLSPolicy;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by albritter on 05.06.16.
 */
public class DataCollector {

    public final static ArrayList<Aliases> aliases = new ArrayList<Aliases>();
    public final static ArrayList<Domain> domains = new ArrayList<Domain>();
    public final static ArrayList<Mailbox> mailboxes = new ArrayList<Mailbox>();
    public final static ArrayList<TLSPolicy> tls = new ArrayList<TLSPolicy>();
    private static ArrayList<ADataObject> queueRemove = new ArrayList<ADataObject>();
    private static ArrayList<ADataObject> queueAdd = new ArrayList<ADataObject>();
    private static ArrayList<ADataObject> queueUdate = new ArrayList<ADataObject>();

    public static <T extends ADataObject> void queuNewObject(T dataObject, queueType type) {
        switch (type) {
            case REMOVE:
                queueRemove.add(dataObject);
                break;
            case ADD:
                queueAdd.add(dataObject);
                break;
            case UPDATE:
                queueUdate.add(dataObject);
                break;
        }
    }

    public static void flushQueus() {
        Iterator<ADataObject> ite = queueAdd.iterator();
        while (ite.hasNext()) {
            MySQLHandler.add(ite.next());
        }
        queueAdd.clear();
        ite = queueRemove.iterator();
        while (ite.hasNext()) {
            MySQLHandler.remove(ite.next());
        }
        queueRemove.clear();
        ite = queueUdate.iterator();
        while (ite.hasNext()) {
            MySQLHandler.update(ite.next());
        }
        queueUdate.clear();
    }

    public enum queueType {
        REMOVE, ADD, UPDATE
    }
}
