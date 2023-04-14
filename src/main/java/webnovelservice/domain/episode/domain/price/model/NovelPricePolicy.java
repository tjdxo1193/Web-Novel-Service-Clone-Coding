package webnovelservice.domain.episode.domain.price.model;

public interface NovelPricePolicy<T> {
    void fixedPricePolicy(T t);
}
