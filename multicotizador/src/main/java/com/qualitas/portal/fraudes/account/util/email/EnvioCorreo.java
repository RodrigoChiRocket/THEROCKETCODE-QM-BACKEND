package com.qualitas.portal.fraudes.account.util.email;

import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class EnvioCorreo {

    private final String host = "smtp.gmail.com";
    private final String port = "465";
    private String fromEmail = "rodrigorafaelchipacheco@gmail.com";
    private String password = "rzlgjdhkkrflvuus";

    public EnvioCorreo() {}

    public boolean enviarCorreo(String toEmail, String nombreUsuario, String contrasena) {

        System.setProperty("https.protocols", "TLSv1.2");

        // Configuración de las propiedades para el servidor SMTP
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

        // Crear una nueva sesión con autenticación
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            // Crear el mensaje
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("¡Bienvenido(a) a nuestra plataforma de Fraudes!");

            // Contenido del correo en formato HTML
            String contenidoHTML = "<html>" +
                    "<body>" +
                    "<h3>Estimado(a) " + nombreUsuario + ",</h3>" +
                    "<p>¡Bienvenido(a) a nuestra plataforma de Fraudes!</p>" +
                    "<p>A continuación, encontrarás tus credenciales de acceso:</p>" +
                    "<ul>" +
                    "<li><strong>Usuario:</strong> " + toEmail + "</li>" +
                    "<li><strong>Contraseña:</strong> " + contrasena + "</li>" +
                    "</ul>" +
                    "<p>Por favor, accede a la plataforma en el siguiente enlace:</p>" +
                    "<a href='https://tuplataforma.com'>https://tuplataforma.com</a>" +
                    "<p>Si tienes alguna duda o necesitas asistencia, no dudes en contactarnos. Estamos aquí para apoyarte.</p>" +
                    "<p>Gracias,<br>Equipo Qualitas</p>" +
                    "</body>" +
                    "</html>";

            // Adjuntar el contenido HTML al mensaje
            message.setContent(contenidoHTML, "text/html; charset=utf-8");

            // Enviar el mensaje
            Transport.send(message);
            System.out.println("Correo enviado exitosamente.");
            return true;

        } catch (MessagingException e) {
            System.err.println("Error al enviar el correo a: " + toEmail);
            e.printStackTrace();
            return false;
        }
    }

    // Correo de restablecimiento de contraseña
    public boolean enviarCorreoRestablecimiento(String toEmail, String nombreUsuario, String token) {
        System.setProperty("https.protocols", "TLSv1.2");

        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Restablecimiento de Contraseña - Qualitas");

            String resetLink = "http://localhost:4200/#/reset-password?token=" + token + "&email=" + toEmail;
            String contenidoHTML = "<!DOCTYPE html>" +
                    "<html>" +
                    "<head>" +
                    "    <meta charset=\"UTF-8\">" +
                    "    <style>" +
                    "        body { font-family: 'Arial', sans-serif; line-height: 1.6; color: #333333; margin: 0; padding: 0; }" +
                    "        .container { max-width: 600px; margin: 20px auto; border: 1px solid #e1e1e1; border-radius: 8px; overflow: hidden; }" +
                    "        .header { background-color: #8cc63f; padding: 20px; text-align: center; }" +
                    "        .header img { max-width: 180px; }" +
                    "        .content { padding: 30px; background-color: #ffffff; }" +
                    "        h1 { color: #8cc63f; font-size: 24px; margin-top: 0; }" +
                    "        .button { display: inline-block; padding: 12px 24px; background-color: #8cc63f; color: #ffffff !important; text-decoration: none; border-radius: 4px; font-weight: bold; margin: 15px 0; }" +
                    "        .footer { background-color: #f5f5f5; padding: 20px; text-align: center; font-size: 12px; color: #777777; }" +
                    "        .divider { border-top: 1px solid #e1e1e1; margin: 20px 0; }" +
                    "        .text-muted { color: #777777; font-size: 12px; }" +
                    "    </style>" +
                    "</head>" +
                    "<body>" +
                    "    <div class=\"container\">" +
                    "        <div class=\"header\">" +
                    "            <!-- Reemplaza con tu logo -->" +
                    "            <img src=\"https://via.placeholder.com/180x60/8cc63f/ffffff?text=Qualitas\" alt=\"Qualitas Logo\">" +
                    "        </div>" +
                    "        <div class=\"content\">" +
                    "            <h1>Restablecer tu contraseña</h1>" +
                    "            <p>Hola " + nombreUsuario + ",</p>" +
                    "            <p>Recibimos una solicitud para restablecer la contraseña asociada a tu cuenta. Haz clic en el botón a continuación para continuar con el proceso.</p>" +
                    "            <p><a href=\"" + resetLink + "\" class=\"button\">Restablecer contraseña</a></p>" +
                    "            <p>Si no puedes hacer clic en el botón, copia y pega el siguiente enlace en tu navegador:</p>" +
                    "            <p><small>" + resetLink + "</small></p>" +
                    "            <div class=\"divider\"></div>" +
                    "            <p class=\"text-muted\">Este enlace expirará en 5 minutos. Si no solicitaste un restablecimiento de contraseña, ignora este mensaje o contacta a nuestro equipo de soporte si tienes alguna pregunta.</p>" +
                    "        </div>" +
                    "        <div class=\"footer\">" +
                    "            <p>&copy; 2023 Qualitas. Todos los derechos reservados.</p>" +
                    "            <p>Si necesitas ayuda, contáctanos en <a href=\"mailto:soporte@qualitas.com\">soporte@qualitas.com</a></p>" +
                    "        </div>" +
                    "    </div>" +
                    "</body>" +
                    "</html>";

            message.setContent(contenidoHTML, "text/html; charset=utf-8");
            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }



}
