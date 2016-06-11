package com.demo.riak.main;

import com.basho.riak.client.api.RiakClient;
import com.basho.riak.client.api.commands.kv.FetchValue;
import com.basho.riak.client.api.commands.kv.StoreValue;
import com.basho.riak.client.core.RiakCluster;
import com.basho.riak.client.core.RiakNode;
import com.basho.riak.client.core.query.Location;
import com.basho.riak.client.core.query.Namespace;
import com.basho.riak.client.core.query.RiakObject;
import com.basho.riak.client.core.util.BinaryValue;

import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by CongDanh on 9/6/15.
 */
public class FistMainTest {

    public static void main(String args[]) throws UnknownHostException, ExecutionException, InterruptedException {
        RiakCluster cluster = RiakUtils.setUpCluster();
        RiakClient client = new RiakClient(cluster);
        System.out.println(client);

        // getting data in
        Namespace ns = new Namespace("default", "java_demo_bucket");
        Location ls = new Location(ns, "java_demo_key");
//        Location ls = new Location(ns, "java_test_key");

        RiakObject riakObject = new RiakObject();
        riakObject.setValue(BinaryValue.create("java_demo_value_2"));
        StoreValue storeValue = new StoreValue.Builder(riakObject).withLocation(ls).build();
        client.execute(storeValue);
        System.out.println("StoreValue operation created");

        // getting data out
        FetchValue fetchValue = new FetchValue.Builder(ls).build();
        FetchValue.Response response = client.execute(fetchValue);
        List<RiakObject> responseObjects = response.getValues(RiakObject.class);
        for (RiakObject obj : responseObjects) {
            System.out.println(obj.getValue().toString());
        }
    }
}
