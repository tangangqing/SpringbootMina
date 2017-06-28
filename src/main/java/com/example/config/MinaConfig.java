package com.example.config;

import com.example.Handler.ServerHandler;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * Created by daile on 2017/6/28.
 */
@Configuration
public class MinaConfig {
    @Bean
    public LoggingFilter loggingFilter(){return new LoggingFilter();}

    @Bean
    public IoHandler ioHandler(){return new ServerHandler();}

    @Bean
    public InetSocketAddress inetSocketAddress(){ return new InetSocketAddress(3001);}

    @Bean
    public IoAcceptor ioAcceptor() throws IOException {
        IoAcceptor acceptor = new NioSocketAcceptor();
        acceptor.getFilterChain().addLast("logger",loggingFilter());
        acceptor.getFilterChain().addLast( "codec", new ProtocolCodecFilter( new TextLineCodecFactory(Charset.forName("UTF-8"))));

        acceptor.setHandler(ioHandler());
        acceptor.getSessionConfig().setReadBufferSize(2048);
        acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE,60);

        acceptor.bind(inetSocketAddress());
        return acceptor;
    }
}
