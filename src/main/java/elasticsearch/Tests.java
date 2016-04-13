package elasticsearch;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.search.SearchHit;

import java.net.InetAddress;
import java.net.InetSocketAddress;


public class Tests {

    public static void main(String... args) {

        new RetrieveAll().retrieveAll();

    }
}
