package hello.archivebackend.domain.article.dto;

public record TocItem(
        int level,
        String id,
        String text
) {
}
