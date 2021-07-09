ARG base_image
FROM ${base_image}

ARG stack_id

USER root
RUN microdnf install -y procps

# Set required CNB information
ENV CNB_STACK_ID=${stack_id}
ENV CNB_USER_ID=185
ENV CNB_GROUP_ID=185
LABEL io.buildpacks.stack.id=${stack_id}

# Set CNB user and group
USER ${CNB_USER_ID}:${CNB_GROUP_ID}

CMD [ "/bin/bash" ]
ENTRYPOINT []
