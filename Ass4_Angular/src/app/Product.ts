import {Owner} from './Owner'
import {Orders} from './Orders'

export class Product
{
 
id: number;
productName: string;

orders : Orders[];   
owner : Owner;   
}