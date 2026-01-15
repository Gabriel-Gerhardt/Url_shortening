## <Project Name>

Url shortener, shorts urls and maps them to their original version

## How It Works

The user save an original url in the database, and a new short url is generated for the user
To retrieve it, he uses a GET with the new url
He can change what he wants to retrieve in the GET, like timesAccessed or other formats

## Tech Stack

Spring Boot 4.0.1
Java 25
PostgreSQL 18

## Use Cases

Social Media Sharing:

  When posting on Twitter, LinkedIn, or Instagram, users want short links to save character space and make posts cleaner.
  
  Example: Sharing a long blog post URL as https://short.ly/abc123.

Marketing Campaigns:

  Marketers want trackable links for emails, ads, or QR codes.
  
  Example: A campaign sends https://short.ly/summer2026 to measure clicks.

Print Materials:

  When adding links to flyers, posters, or business cards, long URLs are inconvenient.
  
  Example: A short URL printed on a brochure directs people to a signup page.

## Set-up

```bash
git clone https://github.com/Gabriel-Gerhardt/Url_shortening
cd Url_shortening
cd short
docker compose up
./gradlew build
./gradlew bootRun
```

Access:

    localhost:8080/shorten(post urls)
    localhost:8080/shorten/STATUS/{shortUrl}(retrieve urls)
    
## Contact
[LinkedIn](https://www.linkedin.com/in/gabriel-gerhardt-0a8b852b9/)

[Gmail](mailto:gabrielgerhardt27@gmail.com)

[GitHub](https://github.com/Gabriel-Gerhardt)

