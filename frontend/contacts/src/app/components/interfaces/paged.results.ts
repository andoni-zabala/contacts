export interface PagedResults<T> {
    results: T[];
    totalResults: number;
    totalPages: number;
}