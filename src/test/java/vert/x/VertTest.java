package vert.x;

import io.vertx.core.Vertx;

/**
 * Created by xuwei on 2017/12/19.
 */
public class VertTest {
    public static void main(String[] args) {
        Vertx.vertx().createHttpServer().requestHandler(req->req.response().end("ha ha d")).listen(8085);
    }

}
