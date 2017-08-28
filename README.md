# dddblog

##Frontend:

Angularjs frontend

needs following Apache2 config to run properly:

    <VirtualHost *:80>
      DirectoryIndex index.html
      DocumentRoot /var/www/html/frontend
      <Directory "/var/www/html/frontend">
        order allow,deny
        allow from all

        RewriteEngine on

        RewriteCond %{REQUEST_FILENAME} -s [OR]
        RewriteCond %{REQUEST_FILENAME} -l [OR]
        RewriteCond %{REQUEST_FILENAME} -d
        RewriteRule ^.*$ - [NC,L]
        RewriteRule ^(.*) /index.html [NC,L]
      </Directory>
    </VirtualHost>

