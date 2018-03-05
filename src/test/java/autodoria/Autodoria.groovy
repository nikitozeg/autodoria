package autodoria

import main.SearchServiceAdapter
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

Document responseObject = null
String searchValue = null
String searchResultLocator = ".mw-search-results li"
String pageContent = ".mw-parser-output"

When(~'^Web service is connected$') { ->
    SearchServiceAdapter.instance.connect()
}

And(~'^Web service is disconnected$') { ->
    SearchServiceAdapter.instance.disconnect()
}

And(~'^Search request is executed with value (.*)') { String search ->
    searchValue = search
    responseObject = SearchServiceAdapter.instance.searchService("/w/index.php?search=", search)
}


Then(~'^Redirecting to search result page$') { ->
    //Check search result page:
    Element content = responseObject.getElementsByTag("i").first();
    content.text().equalsIgnoreCase("The page \"" + searchValue + "\" does not exist. You can ask for it to be created, but consider checking the search results below to see whether the topic is already covered.")
    Elements contents = responseObject.select(searchResultLocator);
    assert contents.size() == 20
}

Then(~'^Redirecting to "([^"]*)" page$') { String pageName ->
    /// Check heading and body content appearing
    assert responseObject.select("h1").first().text().equalsIgnoreCase(pageName)
    assert responseObject.select(pageContent).size() == 1
}










