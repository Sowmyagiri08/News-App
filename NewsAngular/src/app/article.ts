export class Article {

    constructor(public articleId: string, public source: string, public author: string, public title: string, public description: string, public url: string,
        public urlToImage: string, public publishedAt: string, public content: string, public articleAddedBy: string) {
            
    }
}
