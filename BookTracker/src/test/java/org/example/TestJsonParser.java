package org.example;

import Plugin.JsonParser;
import Plugin.Application.Model.Book;
import Plugin.Application.Model.Language;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJsonParser {
    @Test
    public void testStringBookParsing() {
        String input = """
                {
                  "kind": "books#volumes",
                  "totalItems": 148,
                  "items": [
                    {
                      "kind": "books#volume",
                      "id": "xxebAwAAQBAJ",
                      "etag": "6ZNcBigfvRA",
                      "selfLink": "https://www.googleapis.com/books/v1/volumes/xxebAwAAQBAJ",
                      "volumeInfo": {
                        "title": "Die Worte des Lichts",
                        "subtitle": "Roman",
                        "authors": [
                          "Brandon Sanderson"
                        ],
                        "publisher": "Heyne Verlag",
                        "publishedDate": "2014-11-04",
                        "description": "Die Welt Roschar wird von Stürmen und Machtkämpfen erschüttert. Der Krieg zwischen dem Volk von Alethkar und den geheimnisvollen Parshendi tobt bereits jahrelang – ein Krieg, der magische Geheimnisse aus dunkler Vergangenheit heraufbeschwört. Ein Krieg, in dem einfache Menschen als Helden aufstehen, Jäger zu Gejagten werden und sich Magie in Fluch verwandeln kann. Sechs Jahre ist es her, dass der König von Alethkar ermordet wurde. Sein Mörder, ein geheimnisvoller, weiß gewandeter Attentäter, wurde offenbar von dem Volk beauftragt, mit dem der König gerade einen Friedensvertrag unterzeichnet hatte: den Parshendi. In ihrem Rachedurst stellten die Großprinzen der Alethi ein Heer zusammen und zogen gegen die Parshendi in den Krieg. Nun, sechs Jahre später, ist dieser Krieg zu einem Stellungskampf auf der unwirtlichen Zerschmetterten Ebene erstarrt. Schon beginnen sich die Adligen in Intrigen aufzureiben, als plötzlich der Attentäter wieder zurückkehrt – und mit ihm Wesen aus einer vergessen geglaubten Vergangenheit: die Strahlenden Ritter mit ihren magischen Klingen. Können sie den Krieg beenden? Werden sie die Alethi und ganz Roschar vor dem letzten, alles zerstörenden Sturm retten können?",
                        "industryIdentifiers": [
                          {
                            "type": "ISBN_13",
                            "identifier": "9783641071820"
                          },
                          {
                            "type": "ISBN_10",
                            "identifier": "3641071828"
                          }
                        ],
                        "readingModes": {
                          "text": true,
                          "image": true
                        },
                        "pageCount": 976,
                        "printType": "BOOK",
                        "categories": [
                          "Fiction"
                        ],
                        "maturityRating": "NOT_MATURE",
                        "allowAnonLogging": true,
                        "contentVersion": "1.48.45.0.preview.3",
                        "panelizationSummary": {
                          "containsEpubBubbles": false,
                          "containsImageBubbles": false
                        },
                        "imageLinks": {
                          "smallThumbnail": "http://books.google.com/books/content?id=xxebAwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api",
                          "thumbnail": "http://books.google.com/books/content?id=xxebAwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
                        },
                        "language": "de",
                        "previewLink": "http://books.google.de/books?id=xxebAwAAQBAJ&printsec=frontcover&dq=Stromlight+Archives&hl=&cd=1&source=gbs_api",
                        "infoLink": "https://play.google.com/store/books/details?id=xxebAwAAQBAJ&source=gbs_api",
                        "canonicalVolumeLink": "https://play.google.com/store/books/details?id=xxebAwAAQBAJ"
                      },
                      "saleInfo": {
                        "country": "DE",
                        "saleability": "FOR_SALE",
                        "isEbook": true,
                        "listPrice": {
                          "amount": 13.99,
                          "currencyCode": "EUR"
                        },
                        "retailPrice": {
                          "amount": 13.99,
                          "currencyCode": "EUR"
                        },
                        "buyLink": "https://play.google.com/store/books/details?id=xxebAwAAQBAJ&rdid=book-xxebAwAAQBAJ&rdot=1&source=gbs_api",
                        "offers": [
                          {
                            "finskyOfferType": 1,
                            "listPrice": {
                              "amountInMicros": 13990000,
                              "currencyCode": "EUR"
                            },
                            "retailPrice": {
                              "amountInMicros": 13990000,
                              "currencyCode": "EUR"
                            },
                            "giftable": true
                          }
                        ]
                      },
                      "accessInfo": {
                        "country": "DE",
                        "viewability": "PARTIAL",
                        "embeddable": true,
                        "publicDomain": false,
                        "textToSpeechPermission": "ALLOWED",
                        "epub": {
                          "isAvailable": true,
                          "acsTokenLink": "http://books.google.de/books/download/Die_Worte_des_Lichts-sample-epub.acsm?id=xxebAwAAQBAJ&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api"
                        },
                        "pdf": {
                          "isAvailable": true,
                          "acsTokenLink": "http://books.google.de/books/download/Die_Worte_des_Lichts-sample-pdf.acsm?id=xxebAwAAQBAJ&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api"
                        },
                        "webReaderLink": "http://play.google.com/books/reader?id=xxebAwAAQBAJ&hl=&source=gbs_api",
                        "accessViewStatus": "SAMPLE",
                        "quoteSharingAllowed": false
                      },
                      "searchInfo": {
                        "textSnippet": "Die Welt Roschar wird von Stürmen und Machtkämpfen erschüttert."
                      }
                    },
                    {
                      "kind": "books#volume",
                      "id": "U9d7DwAAQBAJ",
                      "etag": "uymQ+xFkl8E",
                      "selfLink": "https://www.googleapis.com/books/v1/volumes/U9d7DwAAQBAJ",
                      "volumeInfo": {
                        "title": "Die Splitter der Macht",
                        "subtitle": "Roman",
                        "authors": [
                          "Brandon Sanderson"
                        ],
                        "publisher": "Heyne Verlag",
                        "publishedDate": "2019-04-22",
                        "description": "Hoch in den Bergen liegt die sagenumwobene Stadt Urithiru, erreichbar nur über die zwölf Eidtore. Hier versucht die junge Edelfrau Schallan Davar die Geheimnisse der uralten Ordensgemeinschaften zu entschlüsseln, die sich einst die Strahlenden Ritter nannten. Nur mit ihrer Hilfe können die Eidtore benutzt werden, und nur ihre Splitterklingen verleihen den Strahlenden übermenschliche Fähigkeiten. Aber wer waren sie wirklich, und warum wurden sie einst aufgelöst? Während Schallan nach Antworten sucht, die bei der Neugründung der Orden helfen können, begreift Fürst Dalinar, dass seine Vision, die Fürsten des Königreichs Alethkar wieder zu einen, noch viel zu klein gedacht war. Nicht nur die Alethi, sondern alle Völker von Roschar müssen vereint werden, denn es droht die alles verheerende Wüstwerdung und damit das Ende von ganz Roschar. Doch ein finsterer Schatten liegt auf dieser Hoffnung – Fürst Dalinars eigene, blutbefleckte Vergangenheit ...",
                        "industryIdentifiers": [
                          {
                            "type": "ISBN_13",
                            "identifier": "9783641175184"
                          },
                          {
                            "type": "ISBN_10",
                            "identifier": "3641175186"
                          }
                        ],
                        "readingModes": {
                          "text": true,
                          "image": true
                        },
                        "pageCount": 1120,
                        "printType": "BOOK",
                        "categories": [
                          "Fiction"
                        ],
                        "maturityRating": "NOT_MATURE",
                        "allowAnonLogging": true,
                        "contentVersion": "1.25.24.0.preview.3",
                        "panelizationSummary": {
                          "containsEpubBubbles": false,
                          "containsImageBubbles": false
                        },
                        "imageLinks": {
                          "smallThumbnail": "http://books.google.com/books/content?id=U9d7DwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api",
                          "thumbnail": "http://books.google.com/books/content?id=U9d7DwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
                        },
                        "language": "de",
                        "previewLink": "http://books.google.de/books?id=U9d7DwAAQBAJ&printsec=frontcover&dq=Stromlight+Archives&hl=&cd=2&source=gbs_api",
                        "infoLink": "https://play.google.com/store/books/details?id=U9d7DwAAQBAJ&source=gbs_api",
                        "canonicalVolumeLink": "https://play.google.com/store/books/details?id=U9d7DwAAQBAJ"
                      },
                      "saleInfo": {
                        "country": "DE",
                        "saleability": "FOR_SALE",
                        "isEbook": true,
                        "listPrice": {
                          "amount": 13.99,
                          "currencyCode": "EUR"
                        },
                        "retailPrice": {
                          "amount": 13.99,
                          "currencyCode": "EUR"
                        },
                        "buyLink": "https://play.google.com/store/books/details?id=U9d7DwAAQBAJ&rdid=book-U9d7DwAAQBAJ&rdot=1&source=gbs_api",
                        "offers": [
                          {
                            "finskyOfferType": 1,
                            "listPrice": {
                              "amountInMicros": 13990000,
                              "currencyCode": "EUR"
                            },
                            "retailPrice": {
                              "amountInMicros": 13990000,
                              "currencyCode": "EUR"
                            },
                            "giftable": true
                          }
                        ]
                      },
                      "accessInfo": {
                        "country": "DE",
                        "viewability": "PARTIAL",
                        "embeddable": true,
                        "publicDomain": false,
                        "textToSpeechPermission": "ALLOWED",
                        "epub": {
                          "isAvailable": true,
                          "acsTokenLink": "http://books.google.de/books/download/Die_Splitter_der_Macht-sample-epub.acsm?id=U9d7DwAAQBAJ&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api"
                        },
                        "pdf": {
                          "isAvailable": true,
                          "acsTokenLink": "http://books.google.de/books/download/Die_Splitter_der_Macht-sample-pdf.acsm?id=U9d7DwAAQBAJ&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api"
                        },
                        "webReaderLink": "http://play.google.com/books/reader?id=U9d7DwAAQBAJ&hl=&source=gbs_api",
                        "accessViewStatus": "SAMPLE",
                        "quoteSharingAllowed": false
                      },
                      "searchInfo": {
                        "textSnippet": "Hoch in den Bergen liegt die sagenumwobene Stadt Urithiru, erreichbar nur über die zwölf Eidtore."
                      }
                    }
                    ]
                  }""";
        ArrayList<Book> result = new JsonParser().parseIntoBooks(input);
        Book b = result.get(0);
        assertEquals("Die Worte des Lichts",b.Title());
        assertEquals("Brandon Sanderson",b.Author());
        assertEquals(976,b.Pagecount());
        assertEquals(Language.DE,b.language());
    }
}
