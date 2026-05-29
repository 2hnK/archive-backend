package hello.archivebackend.domain.article.dto;

import java.util.List;

public record ArticleDetailResponse(
        String title,
        String author,
        String category,
        String contentHtml,
        List<TocItem> toc
) {
}
