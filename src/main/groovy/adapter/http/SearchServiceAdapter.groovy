package adapter.http


import org.jsoup.nodes.Document

/**
 * Created by nikitozeg on 06/03/2018 on deep night
 */

@Singleton(strict = false)

class SearchServiceAdapter extends adapter.http.HttpsServiceAdapter {

    private SearchServiceAdapter() {
        super("https://en.wikipedia.org")
    }

    def Document searchService(String servicePath, String value) {
        return callJsonServiceAsGET(servicePath,value)
    }




}
