/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.cardealership.dto;

import java.util.Objects;

/**
 *
 * @author Cna
 */
public class AccountTypeDto {
    private int accountTypeId;
    private String accountType;
    
	public int getAccountTypeId() {
		return accountTypeId;
	}
	public void setAccountTypeId(int accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

    @Override
    public String toString() {
        return "AccountTypeDto{" + "accountTypeId=" + accountTypeId + ", accountType=" + accountType + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.accountTypeId;
        hash = 79 * hash + Objects.hashCode(this.accountType);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AccountTypeDto other = (AccountTypeDto) obj;
        if (this.accountTypeId != other.accountTypeId) {
            return false;
        }
        if (!Objects.equals(this.accountType, other.accountType)) {
            return false;
        }
        return true;
    }
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
    
    
}
