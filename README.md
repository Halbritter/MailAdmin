# MailAdmin
Mit diesem Programm soll die Verwaltung der Benutzer für eine Mailserverinstallation nach dem Vorbild von Thomas Leister (thomas-leister.de) vereifacht werden.
Es unterstützt die Bearbeitung/Erstellung und Löschung von Benutzern, TLS Richlinenen, Domains und Aliases.

Ihr braucht einen MySQL benutzer mit R/W rechten auf eure Datenbank. Ausserdem müsst ihr euch von extern and der Datenbank anmelden können. 

das programm wird ab Java version 7 unterstützt.  

Soltet ihr Probleme, Anregungen oder Fragen haben, offnet bitte eine Issues damit ich euch helfen kann. 

This program requires a MySQL user with r/w access to your database. Additionally, you have to make sure that you are allowed to connect to your DB from your IP and that your DB accepts external connections
If you are using MySQL then you might want to check your  MySQL server configuration. You can most likely find it at /etc/mysql/my.cf
MariaDB stores this file in a slightly different place. Usually  /etc/mysql/mariadb.conf.d/50-server.cnf

Since version 1.5 this tool will automatically save your connections (without the password) in an SQLite DB on your local hard disk. You can find this file at ~/.mailadmin.db.

You will also need Java 7 or higer to run this programm
