build-app:
	./gradlew shadowJar

local-run:
	sam local start-api

deploy-dev:
	sam deploy --config-env dev --no-fail-on-empty-changeset

deploy-prod:
	sam deploy --config-env prod --no-fail-on-empty-changeset