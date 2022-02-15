export interface PagedResults<T> {
    results: T[];
    pageIndex: number;
    pageSize: number;
    totalPages: number;
    totalResults: number;
}