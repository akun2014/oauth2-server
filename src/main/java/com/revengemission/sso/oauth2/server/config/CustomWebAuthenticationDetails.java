package com.revengemission.sso.oauth2.server.config;

import com.revengemission.sso.oauth2.server.domain.GlobalConstant;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {
	private static final long serialVersionUID = 6975601077710753878L;
	private final String inputVerificationCode;
	private final String graphId;

	public CustomWebAuthenticationDetails(HttpServletRequest request) {
		super(request);
		inputVerificationCode = request.getParameter(GlobalConstant.VERIFICATION_CODE);
		graphId = request.getParameter(GlobalConstant.GRAPH_ID);
	}

	public String getInputVerificationCode() {
		return inputVerificationCode;
	}

	public String getGraphId() {
		return graphId;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()).append("; inputVerificationCode: ").append(this.getInputVerificationCode())
				.append("; graphId: ").append(this.getGraphId());
		return sb.toString();
	}
}
