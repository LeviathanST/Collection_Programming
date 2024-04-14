import { ApiProperty } from "@nestjs/swagger"

export class createProductDto {

    @ApiProperty()
    product_name: string;
    
    @ApiProperty()
    product_id: string;

    @ApiProperty()
    product_thumb: string;

    @ApiProperty()
    product_price: number;

    @ApiProperty()
    product_quantity: number; 

    @ApiProperty()
    product_description: string;

    @ApiProperty()
    product_type: string;

    @ApiProperty()
    product_shop: string;

    @ApiProperty()
    product_attributes: object;
}