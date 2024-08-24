//package com.newagesoft.hinario.config.amqp;
//
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class NovoUsuarioListener {
//
//    @RabbitListener(queues = "cadastro.concluido")
//    public void recebeMensagem(UsuarioDTO usuarioDTO){
//        String dadosUsuario = """
//                ** Dados do usuario **
//                Nome: %s
//                Email: %s
//                """.formatted(usuarioDTO.getNome(), usuarioDTO.getEmail());
//        System.out.println(dadosUsuario);
//    }
//}
