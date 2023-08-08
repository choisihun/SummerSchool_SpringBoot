package org.zerock.ex2.sample;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.awt.*;
import java.security.PublicKey;

@Component
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {

private Chef chef;

private Guest guest;
}
