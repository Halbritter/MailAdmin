package de.albritter.main;

import arlut.csd.crypto.Sha512Crypt;

/**
 * Created by albritter on 08.06.16.
 */
public class Main {
    public static void main(String[] arg) {
        System.out.println(Sha512Crypt.Sha512_crypt("pass", "$6$i7oLWVD6ukSBl45A$", 5000));
        System.out.println(Sha512Crypt.verifyPassword("pass", "$6$xEiviPpy5ns6w.1a$4O9M4mqx6acSo2eQPpy0tOYQF9wZOz/hy8TlKAdKYjHDdN2MuqeU7MI.rx3yeEtQY.3lsIWGA7DCg0YD18xgo/"));
    }
}
