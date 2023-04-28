/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Builder;

import Models.Gender;

/**
 *
 * @author s1rja
 */
public interface HumanBuilder {
    
    public <T extends HumanBuilder> T withFirstName(String firstName);
    
    public <T extends HumanBuilder> T withLastName (String lastName);
    
    public <T extends HumanBuilder> T withPhoneNumber (String phoneNumber);
    
    public <T extends HumanBuilder> T withAddress (String address);
    
    public <T extends HumanBuilder> T withAge (int age);
    
    public <T extends HumanBuilder> T withGender (Gender gender);

}
