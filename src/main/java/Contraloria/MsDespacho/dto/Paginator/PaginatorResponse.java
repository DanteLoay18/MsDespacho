package Contraloria.MsDespacho.dto.Paginator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PaginatorResponse<T> {
    public int page;
    public int rows;
    public int total;
    public T[] items;
}
