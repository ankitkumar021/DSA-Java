/*
public enum PasswordError {

    LENGTH_VIOLATION("Password length is outside allowed range"),
    INVALID_CHARACTER("Password contains invalid character"),
    MISSING_UPPERCASE("Password must contain at least one uppercase character"),
    MISSING_LOWERCASE("Password must contain at least one lowercase character"),
    MISSING_DIGIT("Password must contain at least one digit"),
    MISSING_SYMBOL("Password must contain at least one symbol"),
    REPEATED_CHARACTER("Password contains repeated consecutive character"),
    CONSECUTIVE_SEQUENCE("Password contains ascending or descending sequence");

    private final String message;

    PasswordError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

package com.company.security;

import java.util.Set;

public record PasswordPolicy(
        int minLength,
        int maxLength,
        Set<Character> invalidCharacters) {

    public PasswordPolicy {
        if (minLength <= 0) {
            throw new IllegalArgumentException("minLength must be positive");
        }

        if (maxLength < minLength) {
            throw new IllegalArgumentException(
                    "maxLength must be greater than or equal to minLength");
        }
    }
}

package com.company.security;

import java.util.List;

public record ValidationResult(
        boolean valid,
        List<PasswordError> errors) {

    public static ValidationResult success() {
        return new ValidationResult(true, List.of());
    }

    public static ValidationResult failure(List<PasswordError> errors) {
        return new ValidationResult(false, List.copyOf(errors));
    }
}

package com.company.security.rules;

import com.company.security.PasswordError;
import com.company.security.PasswordPolicy;

import java.util.Optional;

public interface PasswordRule {

    Optional<PasswordError> validate(
            String password,
            PasswordPolicy policy);
}

package com.company.security.rules;

import com.company.security.PasswordError;
import com.company.security.PasswordPolicy;

import java.util.Optional;

public class LengthRule implements PasswordRule {

    @Override
    public Optional<PasswordError> validate(
            String password,
            PasswordPolicy policy) {

        int length = password.length();

        if (length < policy.minLength()
                || length > policy.maxLength()) {
            return Optional.of(PasswordError.LENGTH_VIOLATION);
        }

        return Optional.empty();
    }
}
package com.company.security.rules;

import com.company.security.PasswordError;
import com.company.security.PasswordPolicy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class CharacterCompositionRule implements PasswordRule {

    private static final Pattern UPPERCASE =
            Pattern.compile("[A-Z]");

    private static final Pattern LOWERCASE =
            Pattern.compile("[a-z]");

    private static final Pattern DIGIT =
            Pattern.compile("\\d");

    private static final Pattern SYMBOL =
            Pattern.compile("[^A-Za-z0-9]");

    @Override
    public Optional<PasswordError> validate(
            String password,
            PasswordPolicy policy) {

        if (!UPPERCASE.matcher(password).find()) {
            return Optional.of(PasswordError.MISSING_UPPERCASE);
        }

        if (!LOWERCASE.matcher(password).find()) {
            return Optional.of(PasswordError.MISSING_LOWERCASE);
        }

        if (!DIGIT.matcher(password).find()) {
            return Optional.of(PasswordError.MISSING_DIGIT);
        }

        if (!SYMBOL.matcher(password).find()) {
            return Optional.of(PasswordError.MISSING_SYMBOL);
        }

        return Optional.empty();
    }
}
`

        package com.company.security.rules;

import com.company.security.PasswordError;
import com.company.security.PasswordPolicy;

import java.util.Optional;

public class RepeatedCharacterRule implements PasswordRule {

    @Override
    public Optional<PasswordError> validate(
            String password,
            PasswordPolicy policy) {

        for (int i = 1; i < password.length(); i++) {

            if (Character.toLowerCase(password.charAt(i))
                    == Character.toLowerCase(password.charAt(i - 1))) {

                return Optional.of(
                        PasswordError.REPEATED_CHARACTER);
            }
        }

        return Optional.empty();
    }
}
package com.company.security;

import com.company.security.rules.*;

        import java.util.ArrayList;
import java.util.List;

public class PasswordValidator {

    private final PasswordPolicy policy;

    private final List<PasswordRule> rules;

    public PasswordValidator(PasswordPolicy policy) {

        this.policy = policy;

        this.rules = List.of(
                new LengthRule(),
                new InvalidCharacterRule(),
                new CharacterCompositionRule(),
                new RepeatedCharacterRule(),
                new ConsecutiveSequenceRule()
        );
    }

    public ValidationResult validate(String password) {

        if (password == null || password.isBlank()) {

            return ValidationResult.failure(
                    List.of(PasswordError.LENGTH_VIOLATION));
        }

        List<PasswordError> errors = new ArrayList<>();

        for (PasswordRule rule : rules) {

            rule.validate(password, policy)
                    .ifPresent(errors::add);
        }

        return errors.isEmpty()
                ? ValidationResult.success()
                : ValidationResult.failure(errors);
    }
}*/
