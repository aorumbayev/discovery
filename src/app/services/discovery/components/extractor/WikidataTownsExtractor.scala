package services.discovery.components.extractor

class WikidataTownsExtractor extends SimpleExtractor {

    override protected val prefixes: String =
        """
          |PREFIX wd: <http://www.wikidata.org/entity/>
          |PREFIX wdt: <http://www.wikidata.org/prop/direct/>
          |PREFIX wikibase: <http://wikiba.se/ontology#>
          |PREFIX p: <http://www.wikidata.org/prop/>
          |PREFIX ps: <http://www.wikidata.org/prop/statement/>
          |PREFIX pq: <http://www.wikidata.org/prop/qualifier/>
          |PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
          |PREFIX bd: <http://www.bigdata.com/rdf#>
        """.stripMargin

    override protected val constructClause: String =
        """
          |?town wdt:P31 wd:Q5153359 ;
          |        a wd:Q5153359 ;
          |        rdfs:label ?townLabel ;
          |        wdt:P1082 ?population ;
          |        wdt:P281 ?postalCode ;
          |        wdt:P625 ?coordinateLocation .
        """.stripMargin

    override protected val whereClause: String =
        """
          |?town wdt:P31 wd:Q5153359 ;
          |          wdt:P1082 ?population ;
          |          wdt:P281 ?postalCode ;
          |          wdt:P625 ?coordinateLocation ;
          |          wdt:P17 wd:Q213 .
          |
          |	SERVICE wikibase:label { bd:serviceParam wikibase:language "en" }
        """.stripMargin
}
