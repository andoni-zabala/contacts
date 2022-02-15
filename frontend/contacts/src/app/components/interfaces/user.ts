import { Category } from "./category";
import { ChangeHistory } from "./change.history";

export interface User {
    id: number;
    firstName: string;
    lastName: string;
    email: string;
    phoneNumber : string;
    category: Category;
    changesHistory: ChangeHistory[];
}