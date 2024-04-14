export type ShopParam = {
    shop_name: string;
    shop_thumb?: string;
}

export type removeShopParam = {
    shop_id: string;
}

export type udpateShopParam = {
    shop_id: string,
    shop_name?: string;
    shop_thumb?: string;
}