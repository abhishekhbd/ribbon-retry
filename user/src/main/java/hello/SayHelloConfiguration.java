package hello;

import com.netflix.loadbalancer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;

public class SayHelloConfiguration {

  @Autowired
  IClientConfig ribbonClientConfig;

  @Bean
  public IPing ribbonPing(IClientConfig config) {
    return new MyPing();
  }

  @Bean
  public IRule ribbonRule(IClientConfig config) {
    return new AvailabilityFilteringRule();
  }

  class MyPing extends PingUrl {
    public MyPing() {
      super();
    }

    public MyPing(boolean isSecure, String pingAppendString) {
      super(isSecure, pingAppendString);
    }

    @Override
    public void setPingAppendString(String pingAppendString) {
      super.setPingAppendString(pingAppendString);
    }

    @Override
    public String getPingAppendString() {
      return super.getPingAppendString();
    }

    @Override
    public boolean isSecure() {
      return super.isSecure();
    }

    @Override
    public void setSecure(boolean isSecure) {
      super.setSecure(isSecure);
    }

    @Override
    public String getExpectedContent() {
      return super.getExpectedContent();
    }

    @Override
    public void setExpectedContent(String expectedContent) {
      super.setExpectedContent(expectedContent);
    }

    int a = 1;

    @Override
    public boolean isAlive(Server server) {
      System.out.println("Abhishek: " + a);;
      a ++;
      return super.isAlive(server);
    }
  }

}

