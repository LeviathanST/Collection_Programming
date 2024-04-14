import { ApiProperty } from "@nestjs/swagger";
import { IsOptional, IsString } from "class-validator";

export class ShopDto {
    @ApiProperty()
    @IsString()
    shop_name: string;


    @ApiProperty()
    @IsString()
    shop_thumb?: string;
}

export class removeShopDto {
    @ApiProperty()
    shop_id: string;
}

export class updateShopDto {
    @ApiProperty()
    @IsString()
    shop_id: string;

    @ApiProperty({ required: false })
    @IsOptional()
    @IsString()
    shop_name?: string;

    @ApiProperty({ required: false })
    @IsOptional()
    @IsString()
    shop_thumb?: string;
}