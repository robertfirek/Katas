package org.katas.payment.service;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.katas.payment.gateway.PaymentDetails;
import org.katas.payment.gateway.PaymentGateway;
import org.katas.payment.repository.users.User;
import org.katas.payment.repository.users.UserRepository;
import org.katas.payment.repository.users.exceptions.UserDoesNotExistException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private PaymentGateway paymentGateway;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private PaymentService paymentService;

    @Test
    public void sendPaymentWhenExistingUserDefinedPaymentDetails() throws Exception {
        User existingUser = mock(User.class);
        mockUserRepositoryResponse(existingUser, true);
        PaymentDetails paymentDetails = mock(PaymentDetails.class);

        paymentService.processPayment(existingUser, paymentDetails);

        verify(userRepository).doesUserExist(existingUser);
        verify(paymentGateway).process(paymentDetails);
    }

    @Test
    public void throwsExceptionWhenUserDoesNotExists() throws Exception {
        User notExistingUser = mock(User.class);
        mockUserRepositoryResponse(notExistingUser, false);
        PaymentDetails paymentDetails = mock(PaymentDetails.class);
        expectedException.expect(UserDoesNotExistException.class);

        paymentService.processPayment(notExistingUser, paymentDetails);
    }

    private void mockUserRepositoryResponse(User user, boolean doesUserExist) {
        when(userRepository.doesUserExist(eq(user))).thenReturn(doesUserExist);
    }
}