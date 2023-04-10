package client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import thrift.rpc.api.user.*;

public class ThriftRPCClient {

    public static void main(String args[]) throws TException {
        TTransport transport = new TSocket("localhost", 9905);
        transport.open();

        TProtocol protocol = new TBinaryProtocol(transport);
        UserService.Client client = new UserService.Client(protocol);

        LoginRequest loginRequest = new LoginRequest("nick", "npass");
        APIResponse apiResponse = client.login(loginRequest);
        System.out.println(apiResponse.toString());

        Empty logoutRequest = new Empty();
        LogoutResponse logoutResponse = client.logout(logoutRequest);
        System.out.println(logoutResponse);

        transport.close();
    }
}
