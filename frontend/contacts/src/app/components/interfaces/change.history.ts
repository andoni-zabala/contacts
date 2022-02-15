import { User } from "./user";

export interface ChangeHistory {
    user: User;
    field: string;
    oldValue: string;
    newValue: string;
    performedBy: string;
    date: Date;
}