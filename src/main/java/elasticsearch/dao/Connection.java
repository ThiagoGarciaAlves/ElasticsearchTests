package elasticsearch.dao;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.node.Node;

import java.net.InetSocketAddress;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

public class Connection {

    private Client client;

    public Client createNode() {
        Node node = nodeBuilder().clusterName("cluster_voluntarios").client(true).node();
        client = node.client();
        return client;
    }

    public Client createClient(String ip, int port, String cluster) {

        Settings settings = Settings.settingsBuilder()
                .put("cluster.name", cluster).build();

        client = TransportClient.builder().settings(settings).build()
                .addTransportAddress(new InetSocketTransportAddress(new InetSocketAddress(ip, port)));

        return client;

    }

    public Client createClient() {

        String default_ip = "127.0.0.1";
        int default_port = 9300;
        String default_cluster = "elasticsearch";

        return createClient(default_ip, default_port, default_cluster);

    }

}
