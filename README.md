# dddblog

## Frontend:

Angularjs frontend

needs following Apache2 config to run properly:

(please watch directories and change appropiately)

(ATTENTION: service is mentioned to run on localhost .. important for CORS with backend service)

    <VirtualHost 127.0.0.1:80>
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

## Backend:

Build with maven and start jar in src/target
